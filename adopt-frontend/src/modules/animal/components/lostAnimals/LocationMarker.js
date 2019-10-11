import React from 'react';
const LocationMarker = (props) => {
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

  export default LocationMarker;