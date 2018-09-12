import React, { Component } from 'react'

export default class Cidade extends Component {
    render() {
        return (
            <div class="container">
                <table class="table is-hoverable is-fullwidth">
                    <tr>
                        <th>Estado</th>
                        <th>Cidade</th>
                    </tr>
                    <tr>
                        <td>MA</td>
                        <td>São Luís</td>
                    </tr>
                    <tr>
                        <td>MA</td>
                        <td>Imperatriz</td>
                    </tr>
                </table>
            </div>
        )
    }
}
