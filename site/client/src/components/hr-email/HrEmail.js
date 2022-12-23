import React, {Component} from 'react';
import {Button, ButtonGroup, Container, Table} from "react-bootstrap";
import {Link} from "react-router-dom"
import {Navbar, NavbarBrand} from "reactstrap";
import Url from "../utils/Url";
import Paginate from '../utils/Paginate';
import {map} from "react-bootstrap/ElementChildren";


export default class HrEmail extends Component {
    constructor(props) {
        super(props);
        this.url = new Url();
        this.state = {
            records: [],
            test: [],
            inputText: "",
            currPage: 1,
            recPerPage: 50,
        };
    }

    async componentDidMount() {
        const url = this.url.getUrl();
        const response2 = await fetch(url + '/emails');
        const body2 = await response2.json();
        this.setState({records: body2});
        this.setState({test: body2});
        // console.log(this.state.test)
    }

    inputHandler = (e) => {
        let lowerCase = e.target.value.toLowerCase();
        this.setState({inputText: lowerCase});
    };

    async remove(id) {
        const url = this.url.getUrl();
        await fetch(url + '/email/delete/' + id, {
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

    paginate = (pageNumber) => {
        this.setState({currPage: pageNumber});
    };

    previousPage = () => {
        if (this.state.currPage !== 1) {
            this.setState({currPage: this.state.currPage - 1});
        }
    };

    nextPage = () => {
        if (
            this.state.currPage !==
            Math.ceil(this.state.records.length / this.state.recPerPage)
        ) {
            this.setState({currPage: this.state.currPage + 1});
        }
    };

    indexOfLastRec = () => {
        return this.state.currPage * this.state.recPerPage;
    };

    indexOfFirstRec = () => {
        return this.indexOfLastRec() - this.state.recPerPage;
    };

    currentRec = () => {
        return this.state.records.slice(this.indexOfFirstRec(), this.indexOfLastRec());
    };

    render() {
        const {records: records} = this.state

        const recList =
            this.currentRec().filter((rec) => {
                if (this.state.inputText === "") {
                    return rec;
                } else {
                    return rec.company.companyName
                        .toLowerCase()
                        .includes(this.state.inputText.toLowerCase());
                }
            }).map(rec => {
                return <tr key={rec.email_id}>
                    <td>{rec.company.companyName}</td>
                    <td>{rec.email}</td>
                    <td>
                        <ButtonGroup>
                            <Button><NavbarBrand tag={Link} to={"/email/" + rec.email_id}>Edit</NavbarBrand></Button>
                            <Button size="sm" color="danger" onClick={() => this.remove(rec.email_id)}>Delete</Button>
                        </ButtonGroup>
                    </td>
                </tr>
            });

        return (
            <div>
                <Navbar color="dark" dark expand="md">
                    <Button className="d-flex ms-auto"><NavbarBrand tag={Link}
                                                                    to="/email/new">Add</NavbarBrand></Button>
                </Navbar>
                <Container className='fluid mt-5'>
                    <div className="input-group">
                        <span className="input-group-text">Поиск почт</span>
                        <input
                            className="form-control"
                            type="text"
                            id="outline-basic"
                            onChange={this.inputHandler}
                            value={this.state.inputText}
                        />
                    </div>

                    <Table className="mt-5">
                        <thead>
                        <tr>
                            <th width="30%">Company name</th>
                            <th width="30%">Rh-Email</th>
                            <th width="40%">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        {recList}
                        </tbody>
                    </Table>
                    <Paginate
                        recsPerPage={this.state.recPerPage}
                        totalRecs={this.state.records.length}
                        paginate={this.paginate}
                        previousPage={this.previousPage}
                        nextPage={this.nextPage}
                    />
                </Container>
            </div>
        );
    }
}