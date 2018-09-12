import React, { Component } from 'react'

export default class Empresa extends Component {
  render() {
    return (
        <div class="container">
            <table class="table is-hoverable is-fullwidth">
                <tr>
                    <th>Cnpj</th>
                    <th>Nome da empresa</th>
                </tr>
                <tr>
                    <td>1234567489</td>
                    <td>Mateus supermercados</td>
                </tr>
                <tr>
                    <td>1234567488</td>
                    <td>Supermercados Maciel</td>
                </tr>
            </table>
        </div>
    )
  }
}
