import React, { Component } from 'react';
import './App.css';
import CongViec from "./todo/CongViec";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      list: [],
      item: ''
    };
  }

  handleChange = (event) => {
    this.setState({ item: event.target.value });
  }

  handleAddItem = () => {
    if (this.state.item.trim() !== '') {
      this.setState((prevState) => ({
        list: [...prevState.list, this.state.item],
        item: ''
      }));
    }
  }

  render() {
    return (
        // <div className="App">
        //   <h1>Todo List</h1>
        //   <input
        //       type="text"
        //       placeholder="Enter a task"
        //       value={this.state.item}
        //       onChange={this.handleChange}
        //   />
        //   <button onClick={this.handleAddItem}>Add</button>
        //   <ul>
        //     {this.state.list.map((item, index) => (
        //         <li key={index}>{item}</li>
        //     ))}
        //   </ul>
        // </div>
        <CongViec/>
    );
  }
}

export default App;
