import React, {Component} from 'react';
import {Button, ButtonGroup, Container, Table} from "react-bootstrap";
import {Link} from "react-router-dom"
import {Navbar, NavbarBrand} from "reactstrap";
import Url from "../utils/Url";


export default class Company extends Component {
    constructor(props) {
        super(props);
        this.url = new Url();
        this.remove = this.remove.bind(this);
        this.state = {records: []};
    }

    async componentDidMount() {
        const url = this.url.getUrl();
        const response2 = await fetch(url + '/companies');
        const body2 = await response2.json();
        this.setState({records: body2});
    }

    async remove(id) {
        const url = this.url.getUrl();
        await fetch(url + '/company/delete/' + id, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedClients = [...this.state.records].filter(i => i.id !== id);
            this.setState({clients: updatedClients});
        });
        window.location.reload()
    }

    render() {
        const {records, isLoading} = this.state

        if (isLoading) {
            return <p>Loading...</p>;
        }

        const recList = records.map(rec => {
            return <tr key={rec.company_id}>

                <td>{rec.companyName}</td>
                <td>{rec.rating}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary"><NavbarBrand tag={Link}
                                                                       to={"/company/" + rec.company_id}>Edit</NavbarBrand></Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(rec.company_id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <div className="float-right">
                    <Navbar color="dark" dark expand="md">
                        <Button className="d-flex ms-auto"><NavbarBrand tag={Link}
                                                                        to="/company/new">Add</NavbarBrand></Button>
                    </Navbar>
                </div>
                <Container className='fluid'>

                    <Table className="mt-5">
                        <thead>
                        <tr>
                            <th width="30%">Company name</th>
                            <th width="30%">Rating</th>
                            <th width="40%">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        {recList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}