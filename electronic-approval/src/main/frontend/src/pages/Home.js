import React, {useEffect, useState} from 'react';
import axios from 'axios';
import {write} from "./Write";
import AllList from "./BoardList";
import {useNavigate} from "react-router-dom";

function Home() {
    const movePage= useNavigate();
    const goRead =()=> {
        movePage('/document/get');
    }
    const goWrite =()=> {
        movePage('/document/post');
    }
    const [allData, setallData] = useState([]);
    useEffect(() => {
        axios.get('/document/getAll')
            .then(response => setallData(response.data))
            .catch(error => console.log(error))
    }, []);
    return (
        <div>
            <h2>게시판</h2>
            <div id={'board'}>
                <AllList allData={allData}/>
            </div>
            <button id={'btnWrite'} onClick={goWrite}>글쓰기</button>
        </div>
    );
}
export default Home;