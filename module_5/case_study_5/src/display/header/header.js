import React, {Component} from 'react';

class Header extends Component {
    render() {
        return (
            <>
              <header>
                  <div className="header">
                      <h1>Website Header</h1>
                      <ul className="nav">
                          <li><a href="#">Home</a></li>
                          <li><a href="#">About</a></li>
                          <li><a href="#">Services</a></li>
                          <li><a href="#">Portfolio</a></li>
                          <li><a href="#">Contact</a></li>
                      </ul>
                  </div>
              </header>
            </>
        );
    }
}

export default Header;