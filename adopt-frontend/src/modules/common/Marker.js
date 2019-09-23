import React from 'react';
import '../../styles/userStyles.css'
const Marker = (props) => {
  const { color, name } = props;
  return (
    <div onClick={props.toggleModal}>
      <div 
        className="pin bounce"
        style={{ backgroundColor: color, cursor: 'pointer' }}
        title={name}
      />
      <div className="pulse" />
    </div>
  );
};

  export default Marker;