import React, {useEffect, useState} from 'react';
import axios from 'axios';
import {useNavigate} from "react-router-dom";

const Read =()=> {
    const movePage= useNavigate();
    const goHome =()=> {
        movePage('/');
    }
    const [read, setData] = useState([]);

    useEffect(() => {
        axios.get('/document/get?id=1')
            .then(response => setData(response.data))
            .catch(error => console.log(error))
    }, []);
    return(
        <form id="data-form">
            <table id={"documentRead"}>
                <tr>
                    <th>제목</th>
                    <td id="input-title">{read.title}</td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td id="input-content">{read.content}</td>
                </tr>
                <tr>
                    <th>첨부파일</th>
                    <td><input type="file" id="input-attachment" value={read.attachment} disabled={true}/></td>
                </tr>
                <tr>
                    <th>마감일</th>
                    <td id="input-deadline">{read.deadline}</td>
                </tr>
                <tr>
                    <th>기안자</th>
                    <td><td id="drafter">{read.drafterId}</td></td>
                </tr>
                <tr>
                    <th>시행자</th>
                    <td><td id="executor">{read.executorId}</td></td>
                </tr>
            </table>

            <div id={"btnDocument"}><button onClick={goHome}>뒤로가기</button></div>
        </form>
    );
};

export default Read;