import React from "react";
import styled from 'styled-components';

const StyleSectionDiv = styled.div`
    width: calc(100% - 80px - 80px);
    padding: 20px;
    box-sizing: border-box;

    & > table {
        border-top: 1px solid #333;
        border-collapse: collapse;
        width: 100%;
        & th,
        & td {
            border-bottom: 1px solid #ddd;
            padding: 6px 10px;
            text-align: center;
            font-size: 14px;
        }
    }
    
`;

const KhSection = () => {


    return (
        <StyleSectionDiv>
            <table>
                <colgroup>
                    <col width="10%" />
                    <col width="*" />
                    <col width="20%" />
                    <col width="20%" />
                </colgroup>
                <thead>
                    <tr>
                        <th scope="col">번호</th>
                        <th scope="col">제목</th>
                        <th scope="col">글쓴이</th>
                        <th scope="col">작성일</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>1</td>
                        <td>1</td>
                        <td>1</td>
                    </tr>
                </tbody>
            </table>
        </StyleSectionDiv>
    );
}

export default KhSection;