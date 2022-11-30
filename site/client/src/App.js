import './App.css';
import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css'
import AdminHeader from "./components/headers/AdminHeader";
import HrHeader from "./components/headers/HrHeader";
import UserHeader from "./components/headers/UserHeader";


function App() {

    let a = "admin";

    if (a === "admin") {
        return (
            <div>
                {<AdminHeader/>}
                {/*{<HrHeader/>}*/}
                {/*{<UserHeader/>}*/}
            </div>
        )
    }
}

export default App;
