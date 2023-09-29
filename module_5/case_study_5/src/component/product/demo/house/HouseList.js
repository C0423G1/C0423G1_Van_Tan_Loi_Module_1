import React, {useEffect, useState} from 'react';
import * as HouseService from "../../../Service/demo/HouseService";
import {Link} from "react-router-dom";
import Swal from "sweetalert2";
import {useNavigate} from "react-router-dom";

const HouseList = () => {
    const navigate = useNavigate();
    const handleServiceChange = (e) => {
        switch (e.target.value) {
            case "Villa":
                Swal.fire(`You selected: ${e.target.value}`);
                navigate("/villa")
                break;
            case "House":
                Swal.fire(`You selected: ${e.target.value}`);
                navigate("/house")
                break;
            case "Room":
                Swal.fire(`You selected: ${e.target.value}`);
                navigate("/room")
                break;
        }
    };
    const [currentPage, setCurrentPage] = useState(1);
    const [pageSize, setPageSize] = useState(9);

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
        marginRight: "20px",
        marginBottom: "20px"
    };

    const [cards, setCards] = useState([]);
    // const [isDelete, setDelete] =useState(false)
    const getProduct = async () => {
        setCards(await HouseService.getAllHouse(currentPage, pageSize))
    }

    useEffect(() => {
        getProduct();
    }, [currentPage, pageSize])

    return (
        <>
            <div className="button-product">
                <button className="btn btn-outline-dark" onClick={handleServiceChange} value="Villa">Villa</button>
                <button className="btn btn-outline-dark" onClick={handleServiceChange} value="House">House</button>
                <button className="btn btn-outline-dark" onClick={handleServiceChange} value="Room">Room</button>
            </div>
            <div className="row row-cols-1 row-cols-md-3 g-4 body" style={customStyle}>
                {cards.map((card) => (
                    <div key={card.id} className="col">
                        <div className="card h-100">
                            <img src={card.imageSrc} className="card-img-top"/>
                            <div className="card-body">
                                <h5 className="card-title">{card.serviceName}</h5>
                                <p className="card-text">Diện tích sử dụng: {card.area}m</p>
                            </div>
                            <div className="card-icons">
                                <Link to={`/editHouse/${card.id}`}><i className="fa">&#xf044;</i></Link>
                                <i className="fa">&#xf06e;</i>
                                <Link to={`/deleteHouse/${card.id}`}><i className="material-icons">&#xe872;</i></Link>
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
                    disabled={cards.length <= pageSize}
                    className="pagination-button"
                >
                    Trang Tiếp Theo
                </button>
            </div>
            <Link to="/createDemo">
                <button style={buttonStyle} type="button"
                        className="btn btn-outline-primary float-end">
                    +
                </button>
            </Link>
            {/*<DeleteProduct isDelete={isDelete} />*/}
        </>
    );
};
export default HouseList;
