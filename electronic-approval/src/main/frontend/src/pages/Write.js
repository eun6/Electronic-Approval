import React, {useEffect, useState} from 'react';
import axios from 'axios';
import '../App.css'
import {useNavigate} from "react-router-dom";

const Write =()=> {
    const movePage= useNavigate();
    const goHome =()=> {
        movePage('/');
    }
    const upload =() => {
        const formData = new FormData();
        formData.append("title", document.getElementById("input-title").value);
        formData.append("content", document.getElementById("input-content").value);
        formData.append("deadline", document.getElementById("input-deadline").value);
        formData.append("drafterId", 1);
        formData.append("executorId", 2);

        // const file = document.getElementsByName("file");
        // // 파일
        // Array.from(file).forEach((el) => {
        //     formData.append("attachment", el);
        // });
        axios.post('/document/post', formData, {
            headers: {
                "Content-Type": "multipart/form-data",
            },
        })
            .then(response => console.log(response.data), goHome())
            .catch(error => console.log(error))
    };
    return(
        <form id="data-form" onSubmit={upload} encType={"multipart/form-data"}>
            <table id={"documentRead"}>
                <tr>
                    <th>제목</th>
                    <td><input type="text" name="title" id="input-title" /></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td><textarea id="input-content" rows="4" name="content"></textarea></td>
                </tr>
                <tr>
                    <th>첨부파일</th>
                    <td><input type="text" id="input-attachment" name="file" /></td>
                </tr>
                <tr>
                    <th>마감일</th>
                    <td><input type="date" id="input-deadline" name="deadline"/></td>
                </tr>
                <tr>
                    <th>기안자</th>
                    <td><td>
                        <select id="drafter">
                            <option>김남길</option>
                            <option>코코</option>
                        </select>
                    </td></td>
                </tr>
                <tr>
                    <th>시행자</th>
                    <td><td>
                        <select id="executor">
                            <option>김남길</option>
                            <option>코코</option>
                        </select>
                    </td></td>
                </tr>
            </table>

            <div id={"btnDocument"}><button type={"submit"}>제출하기</button></div>
        </form>
    );
};

export default Write;