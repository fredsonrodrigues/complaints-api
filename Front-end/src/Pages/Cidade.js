import React, { Component } from 'react'
import Complaint from './Complaint'

export default class Cidade extends Component {
    constructor(props) {
        super(props);
        this.state = {
            data: null,
            turn: 1,
            dataCompany: null,
            city: null,
            company: null
        }
    }

    getCities(){
        fetch('http://localhost:8080/complaint/ByCity/')
            .then(response => response.json())
            .then(data => {
                this.setState({ 
                    data: data 
                })
            } 
        );
    }

    TableCities(){
        if (this.state.data) {            
            return this.state.data.map((city) =>
                <tr key={city.city}>
                    <td>{city.state}</td>
                    <td>{city.city}</td>
                    <td><a className="button is-success" id="1"
                        onClick={this.getCompany.bind(this, city.city)}>
                        Ver empresas</a>
                    </td>
                </tr>
            );
        } else {
            return  <tr>
                        <td> --- </td>
                        <td> --- </td>
                    </tr>
        }
    }

    getCompany(city) {
        fetch(`http://localhost:8080/complaint/ByCity/${encodeURI(city)}`)
            .then(response => response.json())
            .then(data => {
                this.setState({
                    turn: 2,
                    city: city,
                    dataCompany: data
                })
            }
            );
    }

    TableCompany() {
        if (this.state.dataCompany) {
            return this.state.dataCompany.map((c) =>
                <tr key={c.company.id}>
                    <td>{c.company.name}</td>
                    <td>{c.complaints}</td>
                    <td><a className="button is-success" id="1"
                        onClick={this.getComplaints.bind(this, c.company.id)}>
                        Ver Reclamações</a></td>
                </tr>
            );
        } else {
            return <tr>
                <td> --- </td>
                <td> --- </td>
            </tr>
        }
    }

    getComplaints(company){
        this.setState({
            turn: 3,
            company: company
        })
    }

    backHistory() {
        let turn = this.state.turn - 1
        this.setState({
            turn: turn
        })
    }

    backButton(){
        return <div className="columns">
            <div className="column">
            </div>
            <div className="column">
                <a className="button is-danger is-fullwidth" onClick={this.backHistory.bind(this)}>Voltar</a>
            </div>
            <div className="column">
            </div>
        </div>
    }

    componentDidMount() {
        this.getCities()
    }
    
    render() {
        let func
        let action
        if (this.state.turn === 1) {
            func = <table className="table is-hoverable is-fullwidth">
                    <thead>
                        <tr>
                            <th>Estado</th>
                            <th>Cidade</th>
                            <th> --- </th>
                        </tr>
                    </thead>
                <tbody>
                    {this.TableCities()}
                </tbody>
            </table>
            action = <div></div>
        } else if (this.state.turn === 2) {
            func = <table className="table is-hoverable is-fullwidth">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Quantidade</th>
                        <th> --- </th>
                    </tr>
                </thead>
                <tbody>
                    {this.TableCompany()}
                </tbody>
            </table>
            action = this.backButton()
        } else if (this.state.turn === 3) {
            func = <Complaint empresa={this.state.company} cidade={this.state.city} />
            action = this.backButton()
        }
        return (
            <div className="container">
                {func}
                <br/>
                {action}
            </div>
        )
    }
}
