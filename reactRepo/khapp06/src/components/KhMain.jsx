import React from "react";
import KhAside from "./KhAside";
import KhSection from "./KhSection";

const KhMain = () => {
    const x = {
        display: 'flex',
        padding: '20px',
        boxSizing: 'border-box',
        flexWrap: 'wrap',
        alignItems: 'center',
        justifyContent: 'space-between',
        minHeight: 'calc(100vh - 150px - 41px)'
    }
    return (<>
        <div style={x}>
            <KhAside />
            <KhSection/>
            <KhAside />
        </div>
    </>);
}
export default KhMain;