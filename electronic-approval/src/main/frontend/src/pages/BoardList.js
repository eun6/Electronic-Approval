import React from "react";
import {useNavigate} from "react-router-dom";
const AllList = ({ allData }) => {
    const movePage= useNavigate();
    const goRead =()=> {
        movePage('/document/get');
    }
    return (
        <div>
            {allData.map(data => {
                const date = data.date.substr(0,10);
                return (
                    <div key={data.id}>
                        <div>
                            <table id={'boardList'}>
                                <th>번호</th><th>제목</th><th>날짜</th><th>마감일</th><th>기안자</th><th>시행자</th>
                                <tr><td>{data.id}</td><td onClick={goRead}>{data.title}</td>
                                    <td>{date}</td>
                                    <td>{data.deadline}</td><td>{data.drafter}</td>
                                    <td>{data.executor}</td></tr>
                            </table>
                        </div>
                    </div>)
            })}
        </div>
    );
};

export default AllList;