import React, { Component } from 'react'

export default class Complaint extends Component {
    constructor(props) {
        super(props);
        this.state = {
            data: null,
        }
    }

    getComplaints() {
        fetch(`http://localhost:8080/complaint/ByCompany/${this.props.empresa}/${encodeURI(this.props.cidade)}`)
            .then(response => response.json())
            .then(data => {
                this.setState({
                    data: data
                })
            }
            );
    }

    componentWillMount = () => {
        this.getComplaints()
    }
    
    render() {
        let cardlist

        if (this.state.data) {
            cardlist = this.state.data.map((complaint) =>
                <div className="card" key={complaint.id}>
                    <div className="card-content">
                        <p className="title">
                            {complaint.title}
                        </p>
                        <p className="subtitle">
                            {complaint.description}
                        </p>
                    </div>
                    <footer className="card-footer">
                        <p className="card-footer-item">
                            <span>
                                <strong>Autor: </strong> {complaint.name}
                            </span>
                        </p>
                        <p className="card-footer-item">
                            <span>
                                <strong>Cidade: </strong> {this.props.cidade}
                            </span>
                        </p>
                    </footer>
                </div>
            );
        } else {
            cardlist = <div>Nada encontrado</div>
        }

        return (
            <div>
                {cardlist}
            </div>
        )
    }
}
