import React, {Component} from 'react';
import {Button, ButtonGroup, Container, Table} from "react-bootstrap";
import {Link} from "react-router-dom"
import {Navbar, NavbarBrand} from "reactstrap";
import Url from "../utils/Url";


export default class HrUser extends Component {
    constructor(props) {
        super(props);
        this.url = new Url();
        this.state = {records: []};
    }

    async componentDidMount() {
        const url = this.url.getUrl();
        const response2 = await fetch(url+ '/users/hrs');
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
        const {records: records} = this.state

        const recList = records.map(rec => {
            return <tr key={rec.hr_user_id}>
                <td>{rec.company.companyName}</td>
                <td>{rec.hrName}</td>
                <td>
                    <ButtonGroup>
                        {/*<Button><NavbarBrand tag={Link} to="/company/edit">Edit</NavbarBrand></Button>*/}
                        <Button size="sm" color="danger" onClick={() => this.remove(rec.email_id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <Navbar color="dark" dark expand="md">
                    <Button className="d-flex ms-auto"><NavbarBrand tag={Link}
                                                                    to="/user/hr/new">Add</NavbarBrand></Button>
                </Navbar>
                <Container className='fluid'>
                    <Table className="mt-5">
                        <thead>
                        <tr>
                            <th width="30%">Company name</th>
                            <th width="30%">Rh-Name</th>
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