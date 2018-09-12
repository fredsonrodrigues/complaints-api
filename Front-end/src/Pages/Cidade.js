import React, { Component } from 'react'

export default class Cidade extends Component {
    constructor(props) {
        super(props);
        this.state = {
            data: null,
        }
    }

    TableCities(){
        if (this.state.data) {            
            return this.state.data.map((city) =>
                <tr key={city.city}>
                    <td>{city.state}</td>
                    <td>{city.city}</td>
                </tr>
            );
        } else {
            return  <tr>
                        <td> --- </td>
                        <td> --- </td>
                    </tr>
        }
    }
    
    componentDidMount() {
        fetch('http://localhost:8080/complaint/ByCity/')
            .then(response => response.json())
            .then(data => {
                this.setState({ 
                    data: data 
                })
            } 
        );
    }
    
    render() {
        return (
            <div className="container">
                <table className="table is-hoverable is-fullwidth">
                <thead>
                    <tr>
                        <th>Estado</th>
                        <th>Cidade</th>
                    </tr>
                </thead>
                <tbody>
                    {this.TableCities()}
                </tbody>
                </table>
            </div>
        )
    }
}
