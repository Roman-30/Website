import React, {Component} from 'react';
import {Button, NavbarBrand} from "reactstrap";
import {Link} from "react-router-dom";

class UserRecord extends Component {
    render() {
        return (
            <div>
                Вот тута будут рекорды которые оставляли пользователи о компании и собеседовании в ней

                <Button className="d-flex ms-auto"><NavbarBrand tag={Link}
                                                                to="/user/record/new">Add</NavbarBrand></Button>
            </div>
        );
    }
}

export default UserRecord;