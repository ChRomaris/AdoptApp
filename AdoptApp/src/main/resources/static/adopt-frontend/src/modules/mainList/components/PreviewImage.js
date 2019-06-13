import React from 'react';
import '../../../styles/imageStyle.css';

const PreviewImage = (props) => (
<img className="preview" src={props.image} alt="imagen"></img>
);

export default PreviewImage;



