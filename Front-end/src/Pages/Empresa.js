import React, { Component } from 'react'

export default class Empresa extends Component {
    constructor(props) {
        super(props);
        this.state = {
            data: null,
            cityData: null,
            complaintData: null,
            turn: 1,
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
        this.setState({turn: 2})
        fetch(`http://localhost:8080/complaint/ByCompany/${id}`)
            .then(response => response.json())
            .then(data => {
                this.setState({
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
                        onClick={this.CardsComplaints.bind(this)}>
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

    CardsComplaints(){
        this.setState({ turn: 3 })
    }

    componentDidMount() {
        this.getCompanies();
    }

    render() {
        let func
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
        } else if (this.state.turn === 3) {
            func = <h1>Essas são as reclamações</h1>
        }
        return (
            <div className="container">
                {func}
            </div>
        )
    }
}
