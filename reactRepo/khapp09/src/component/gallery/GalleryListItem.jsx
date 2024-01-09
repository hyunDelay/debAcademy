import React from 'react';
import styled from 'styled-components';

const StyledWrapDiv = styled.div`
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    gap: 5px;
`;

const GalleryListItem = ({title, fullPath}) => {
    return (
        <StyledWrapDiv>
            <img 
                src={fullPath}
                alt='이미지' 
                width='120px'
                height='120px'
            />
            <span>{title}</span>
        </StyledWrapDiv>
    );
};

export default GalleryListItem;