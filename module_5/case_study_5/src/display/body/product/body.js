import React, {useState} from 'react';
import {Link} from 'react-router-dom';
import Header from "../../header/header";
import Footer from "../../footer/footer";

const Body = () => {
    const customStyle = {
        width: '70%',
        margin: '0 auto',
        display: 'flex',
        flexWrap: 'wrap',
        justifyContent: 'space-between',
    };

    const buttonStyle = {
        width: '50px',
        height: '50px',
        fontSize: '24px',
        cursor: 'pointer',
        marginRight: "20px"
    };

    const [cards, setCards] = useState([
        {
            id: 1,
            title: 'Card title 1',
            roomSize: '40m',
            imageSrc: 'https://furamavietnam.com/wp-content/uploads/2018/03/Vietnam_Danang_Furama_Ocean-Suite-Feature-370x239.jpg',
        },
        {
            id: 1,
            title: 'Card title 1',
            roomSize: '40m',
            imageSrc: 'https://furamavietnam.com/wp-content/uploads/2018/03/Vietnam_Danang_Furama_Ocean-Suite-Feature-370x239.jpg',
        },
        {
            id: 1,
            title: 'Card title 1',
            roomSize: '40m',
            imageSrc: 'https://furamavietnam.com/wp-content/uploads/2018/03/Vietnam_Danang_Furama_Ocean-Suite-Feature-370x239.jpg',
        },
        {
            id: 1,
            title: 'Card title 1',
            roomSize: '40m',
            imageSrc: 'https://furamavietnam.com/wp-content/uploads/2018/03/Vietnam_Danang_Furama_Ocean-Suite-Feature-370x239.jpg',
        },
        {
            id: 1,
            title: 'Card title 1',
            roomSize: '40m',
            imageSrc: 'https://furamavietnam.com/wp-content/uploads/2018/03/Vietnam_Danang_Furama_Ocean-Suite-Feature-370x239.jpg',
        },
        {
            id: 1,
            title: 'Card title 1',
            roomSize: '40m',
            imageSrc: 'https://furamavietnam.com/wp-content/uploads/2018/03/Vietnam_Danang_Furama_Ocean-Suite-Feature-370x239.jpg',
        },
    ]);

    const addCard = () => {

    };

    return (
        <>
            <div className="row row-cols-1 row-cols-md-3 g-4" style={customStyle}>
                {cards.map((card) => (
                    <div key={card.id} className="col">
                        <div className="card h-100">
                            <img src={card.imageSrc} className="card-img-top"/>
                            <div className="card-body">
                                <h5 className="card-title">{card.title}</h5>
                                <p className="card-text">Room size: {card.roomSize}</p>
                            </div>
                            <div className="card-icons">
                                <i className="fa">&#xf044;</i>
                                <i className="fa">&#xf06e;</i>
                                <i className="material-icons">&#xe872;</i>
                            </div>
                        </div>
                    </div>
                ))}
            </div>
            <button style={buttonStyle} type="button" className="btn btn-outline-info float-end" onClick={addCard}>
                +
            </button>
        </>
    );
};

export default Body;
