import React from 'react';
import { Link } from 'react-router-dom';

function Header() {
    const headerStyle = {
        background: '#333',
        color: '#fff',
        padding: '10px',
        marginBottom: '20px',
    };

    const navStyle = {
        listStyle: 'none',
        padding: '0',
    };

    const listItemStyle = {
        display: 'inline',
        margin: '0 10px',
    };

    const linkStyle = {
        color: '#fff',
        textDecoration: 'none',
    };

    return (
        <header style={headerStyle}>
            <div className="header">
                <h1>Website Header</h1>
                <ul style={navStyle}>
                    <li style={listItemStyle}>
                        <Link to="/" style={linkStyle}>
                            Home
                        </Link>
                    </li>
                    <li style={listItemStyle}>
                        <Link to="/customer" style={linkStyle}>
                            Customer
                        </Link>
                    </li>
                    <li style={listItemStyle}>
                        <Link to="/contract" style={linkStyle}>
                            Contract
                        </Link>
                    </li>
                </ul>
            </div>
        </header>
    );
}

export default Header;
