import React, {Component} from 'react';
import {Link} from 'react-router-dom';
import {Button, Container, Form, FormGroup} from "react-bootstrap";
import {NavbarBrand} from "reactstrap";
import Url from "../utils/Url";
import withNavigateHook from "../utils/withNavigateHook";

export class CompanyAdd extends Component {


    emptyItem = {
        companyName: '',
        rating: ''
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
            const client = await (await fetch(url + "/company/" + this.props.params.id)).json();
            console.log(client)
            this.setState({item: client});
        }
    }

    handleChange(event) {
        console.log(this.props.params.id);
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let item = {...this.state.item};
        item[name] = value;
        this.setState({item});
    }

    async handleSubmit(event) {
        event.preventDefault();
        const {item} = this.state;
        const url = this.url.getUrl();
        await fetch(url + '/company' + (this.props.params.id !== 'new' ? '/edit' : '/new'), {
            method: this.props.params.id !== 'new' ? 'PUT' : 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(item),
        });
        this.props.history.push('/companies');
        window.location.reload()
    }

    render() {
        const {item} = this.state;
        const title = <h2>{this.props.params.id !== 'new' ? 'Edit Company' : 'Add Company'}</h2>;

        return (
            <div>
                <Container>
                    {title}
                    <Form>
                        <FormGroup>
                            <label>Company name</label>
                            <input type="text" name="companyName" id="companyName" value={item.companyName || ''}
                                   onChange={this.handleChange} autoComplete="companyName"/>
                        </FormGroup>
                        <FormGroup>
                            <label>Rating</label>
                            <input type="text" name="rating" id="rating" value={item.rating || ''}
                                   onChange={this.handleChange} autoComplete="rating"/>
                        </FormGroup>
                        <FormGroup>
                            <Button variant="primary" type="submit" onClick={this.handleSubmit}>Save</Button>
                            <Button><NavbarBrand tag={Link} to="/companies">Cansel</NavbarBrand></Button>
                        </FormGroup>
                    </Form>
                </Container>
            </div>);
    }
}

export default withNavigateHook(CompanyAdd);
