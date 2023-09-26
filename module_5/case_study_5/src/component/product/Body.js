import React, {useEffect, useState} from 'react';
import * as ProductService from "../Service/ProductService";
import {Link} from "react-router-dom";
import DeleteProduct from "./DeleteProduct";

const Body = () => {
    const [currentPage, setCurrentPage] = useState(1);
    const [pageSize, setPageSize] = useState(10);

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

    const [cards, setCards] = useState([]);
    // const [isDelete, setDelete] =useState(false)
    const getProduct = async () => {
        setCards(await ProductService.getAll(currentPage, pageSize))
    }

    useEffect(() => {
        getProduct();
    }, [currentPage, pageSize])

    return (
        <>
            <div className="row row-cols-1 row-cols-md-3 g-4 body" style={customStyle}>
                {cards.map((card) => (
                    <div key={card.id} className="col">
                        <div className="card h-100">
                            <img src={card.imageSrc} className="card-img-top"/>
                            <div className="card-body">
                                <h5 className="card-title">{card.title}</h5>
                                <p className="card-text">Room size: {card.roomSize}</p>
                            </div>
                            <div className="card-icons">
                                <Link to={`/editProduct/${card.id}`}><i className="fa">&#xf044;</i></Link>
                                <i className="fa">&#xf06e;</i>
                                <Link to={`/deleteProduct/${card.id}`}><i className="material-icons">&#xe872;</i></Link>
                            </div>
                        </div>
                    </div>
                ))}
            </div>
            <div className="pagination-buttons">
                <button
                    onClick={() => setCurrentPage(currentPage - 1)}
                    disabled={currentPage === 1 || cards.length === 0}
                    className="pagination-button"
                >
                    Trang Trước
                </button>
                <button
                    onClick={() => setCurrentPage(currentPage + 1)}
                    disabled={cards.length < pageSize}
                    className="pagination-button"
                >
                    Trang Tiếp Theo
                </button>
            </div>
            <Link to="/createProduct">
                <button style={buttonStyle} type="button" className="btn btn-outline-info float-end">
                    +
                </button>
            </Link>
            {/*<DeleteProduct isDelete={isDelete} />*/}
        </>
    );
};
export default Body;
