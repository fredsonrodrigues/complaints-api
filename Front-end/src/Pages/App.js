import React, { Component } from 'react';
import Header from '../Components/Header'

import Empresa from './Empresa'
import Cidade from './Cidade'

class App extends Component {

  constructor(props) {
    super(props);
    this.state = {
      classChange: 1
    }
  }

  changeNow(cod){
    this.setState({ classChange: cod })
  }

  Footer() {
    return (
      <div className="hero-foot">
        <nav className="tabs is-boxed is-fullwidth">
          <div className="container">
            <ul>
              <li className={(this.state.classChange === 1 ? "is-active" : "")}>
                <a onClick={(e) => this.changeNow(1)}>Lista por Empresa</a>
              </li>
              <li className={(this.state.classChange === 2 ? "is-active" : "")}>
                <a onClick={(e) => this.changeNow(2)}>Lista por cidades</a>
              </li>
            </ul>
          </div>
        </nav>
      </div>
    )
  }

  Hero() {
    return (
      <section className="hero is-success">
        <Header />
        <div className="hero-body">
          <div className="container has-text-centered">
            <p className="title">
              {this.state.classChange === 1 ? "Lista de Empresas" : "Lista de Cidades"}
            </p>
            <p className="subtitle">
              {this.state.classChange === 1 ? "Reclamações por Cidade" : "Reclamações por Empresa"}
          </p>
          </div>
        </div>
        {this.Footer()}
      </section>
    );
  }

  Selector() {
    if (this.state.classChange === 1) {
      return <Empresa />;
    }
    return <Cidade />;
  }

  render() {
    return (
      <div>
        {this.Hero()}
        {this.Selector()}
      </div>
    );
  }
}

export default App;
