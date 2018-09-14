import React, { Component } from 'react'
import Complaint from './Complaint'


export default class Empresa extends Component {
    constructor(props) {
        super(props);
        this.state = {
            data: null,
            cityData: null,
            complaintData: null,
            turn: 1,
            company: null,
            city: null,
        }
    }

    getCompanies(){
        fetch('http://localhost:8080/company/')
            .then(response => response.json())
            .then(data => {
                this.setState({
                    data: data
                })
            }
        );
    }

    TableCompanies() {
        if (this.state.data) {
            return this.state.data.map((company) =>
                <tr key={company.id}>
                    <td>{company.cnpj}</td>
                    <td>{company.name}</td>
                    <td><a className="button is-success" id="1"
                        onClick={this.getCompanyCities.bind(this, company.id)}>
                        Ver cidades</a>
                    </td>
                </tr>
            );
        } else {
            return <tr>
                <td> --- </td>
                <td> --- </td>
            </tr>
        }
    }

    getCompanyCities(id) {
        fetch(`http://localhost:8080/complaint/ByCompany/${id}`)
        .then(response => response.json())
        .then(data => {
                this.setState({
                    turn: 2, 
                    company: id,
                    cityData: data
                })
            }
        );
    }

    TableCompanyCities() {
        if (this.state.cityData) {
            return this.state.cityData.map((company) =>
                <tr key={company.city}>
                    <td>{company.city}</td>
                    <td>{company.state}</td>
                    <td>{company.complaints}</td>
                    <td><a className="button is-success" id="2"
                        onClick={this.CardsComplaints.bind(this, company.city)}>
                        Ver Reclamações</a>
                    </td>
                </tr>
            );
        } else {
            return <tr>
                <td> --- </td>
                <td> --- </td>
            </tr>
        }
    }

    CardsComplaints(city){
        this.setState({ turn: 3, city: city })
    }

    backHistory() {
        let turn = this.state.turn - 1
        this.setState({
            turn: turn
        })
    }

    backButton() {
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
        this.getCompanies();
    }

    render() {
        let func
        let action
        if (this.state.turn === 1) {
            func = <table className="table is-hoverable is-fullwidth">
            <thead>
                <tr>
                    <th>Cnpj</th>
                    <th>Nome da empresa</th>
                    <th>---</th>
                </tr>
            </thead>
                <tbody>
                    {this.TableCompanies()}          
                </tbody>
        </table>
            action = <div></div>
        } else if (this.state.turn === 2) {
            func = <table className="table is-hoverable is-fullwidth">
            <thead>
                <tr>
                    <th>Estado</th>
                    <th>Cidade</th>
                    <th>Reclamações (qtd.)</th>
                </tr>
            </thead>
                <tbody>
                    {this.TableCompanyCities()}
                </tbody>
            </table>
            action = this.backButton()
        } else if (this.state.turn === 3) {
            func = <Complaint empresa={this.state.company} cidade={this.state.city}/>
            action = this.backButton()
        }
        return (
            <div className="container">
                {func}
                <br />
                {action}
            </div>
        )
    }
}
