import React, {Component} from 'react';
import {Link} from 'react-router-dom';
import {Button, Container, Form, FormGroup} from "react-bootstrap";
import {NavbarBrand} from "reactstrap";
import Url from "../utils/Url";
import withNavigateHook from "../utils/withNavigateHook";

export class HrEmailAdd extends Component {


    emptyItem = {
        company: {
            companyName: ''
        },
        email: ''
    };

    constructor(props) {
        super(props);
        this.url = new Url()
        this.state = {
            item: this.emptyItem
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    async componentDidMount() {
        if (this.props.params.id !== 'new') {
            const url = this.url.getUrl();
            const client = await (await fetch(url + "/email/" + this.props.params.id)).json();
            this.setState({item: client});
            console.log(this.state.item)
        }
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let item = {...this.state.item};
        if (name === "companyName") {
            console.log("Hello im here");
            item["company"].companyName = value;
        }
        item[name] = value;
        console.log(item)
        this.setState({item});
    }

    // async handleSubmit(event) {
    //     event.preventDefault();
    //     const {item} = this.state;
    //     const url = this.url.getUrl();
    //     await fetch(url + '/email/new', {
    //         method: 'POST',
    //         headers: {
    //             'Accept': 'application/json',
    //             'Content-Type': 'application/json'
    //         },
    //         body: JSON.stringify(item),
    //     });
    //     window.location.reload()
    // }

    async handleSubmit(event) {
        event.preventDefault();
        const {item} = this.state;
        const url = this.url.getUrl();
        await fetch(url + '/email' + (this.props.params.id !== 'new' ? '/edit' : '/new'), {
            method: this.props.params.id !== 'new' ? 'PUT' : 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(item),
        });
        this.props.history.push('/email');
        window.location.reload()
    }

    render() {
        const {item} = this.state;
        const title = <h2>{this.props.params.id !== 'new' ? 'Edit Hr Email' : 'Add Hr Email'}</h2>;

        const url = this.url.getUrl();

        const comp = fetch(url+ '/companies');

        console.log(comp.json())

        // let res = body2.map(rec => {
        //     return <select key={rec.company_id}>
        //         <option value=rec.companyName> s </option>
        //     </select>
        // });

        return (
            <div>
                <Container>
                    {title}
                    <Form>
                        <FormGroup>
                            {/*{res}*/}
                        </FormGroup>
                        <FormGroup>
                            <label>Company name</label>
                            <input type="text" name="companyName" id="companyName" value={item.company.companyName || ''}
                                   onChange={this.handleChange} autoComplete="companyName"/>
                        </FormGroup>
                        <FormGroup>
                            <label>Email</label>
                            <input type="text" name="email" id="email" value={item.email || ''}
                                   onChange={this.handleChange} autoComplete="email"/>
                        </FormGroup>
                        <FormGroup>
                            <Button variant="primary" type="submit" onClick={this.handleSubmit}>Save</Button>
                            <Button><NavbarBrand tag={Link} to="/emails">Cansel</NavbarBrand></Button>
                        </FormGroup>
                    </Form>
                </Container>
            </div>);
    }
}

export default withNavigateHook(HrEmailAdd)
