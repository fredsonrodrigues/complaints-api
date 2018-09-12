import React, { Component } from 'react'

export default class Header extends Component {
  render() {
    return (
        <div class="hero-head">
            <nav class="navbar">
                <div class="container">
                    <div class="navbar-brand">
                        <a class="navbar-item">
                            <h1>Complaints Register</h1>
                        </a>
                        <span class="navbar-burger burger" data-target="navbarMenuHeroB">
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
