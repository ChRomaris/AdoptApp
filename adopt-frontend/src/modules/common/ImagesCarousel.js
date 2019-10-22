import React,{ Component } from "react"; 
import  './styles/common.css'




class ImagesCarousel extends Component{
    constructor(props){
        super(props)
        this.state = {
            images:[]
        }

        this.keyCount = 0
        this.getKey = this.getKey.bind(this);
        this.renderImages = this.renderImages.bind(this);
    }


    getKey(){
        return this.keyCount++;
    }

    renderImages(){
        return(
         this.props.images.map(image=>(
            console.log(image),
           <div key ={"d"+this.getKey}>
           <img key ={"i"+this.getKey}
             alt=''
             src={image.base64}
             className = "carouselImage"
           />
           </div> 
    ))  )
    }

render(){
    return(
        <div className="carouselContainer">
            {this.renderImages()}

        </div>
    )
}
}

export default ImagesCarousel;