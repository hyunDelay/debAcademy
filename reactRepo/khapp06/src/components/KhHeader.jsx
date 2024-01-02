import React from "react";
import LoginArea from "./LoginArea";

const KhHeader = () => {

    const x = {
        position: 'relative',
        backgroundColor : '#f5f5f5',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        width: '100%',
        height: '150px'
    }

    return (<>
        <div style={x}>
            <div></div>
            <h1>FINAL99</h1>
            <LoginArea/>
        </div>
    </>);
}
export default KhHeader;