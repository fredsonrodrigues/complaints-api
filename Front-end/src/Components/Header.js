import React, { Component } from 'react'

export default class Header extends Component {
  render() {
    return (
        <div className="hero-head">
            <nav className="navbar">
                <div className="container">
                    <div className="navbar-brand">
                        <a className="navbar-item">
                            <h1>Complaints Register</h1>
                        </a>
                        <span className="navbar-burger burger" data-target="navbarMenuHeroB">
                            <span></span>
                            <span></span>
                            <span></span>
                        </span>
                    </div>
                </div>
            </nav>
        </div>
    )
  }
}
