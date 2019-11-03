import * as React from 'react'

import { IDistanceResults } from './actions'

import '../App.css'

export function DistancesPage({distances}: {distances: IDistanceResults | null}) {
    return (
        <div>
        {
            distances === null
            ? <p>Loading ... </p>
            : <DistanceResult distances={distances} />
       }
       </div>
    )
}

function DistanceResult({distances}: {distances: IDistanceResults}) {
    return (
        <table>
            <thead>
                <tr>
                    <th>Distance</th><th>Run Count</th>
                </tr>
            </thead>
            <tbody>
            <tr><td>+.5 mi:</td><td><SingleDistanceBar distance={distances["5"]} /></td></tr>
            <tr><td>+.4 mi:</td><td><SingleDistanceBar distance={distances["4"]} /></td></tr>
            <tr><td>+.3 mi:</td><td><SingleDistanceBar distance={distances["3"]} /></td></tr>
            <tr><td>+.2 mi:</td><td><SingleDistanceBar distance={distances["2"]} /></td></tr>
            <tr><td>+.1 mi:</td><td><SingleDistanceBar distance={distances["1"]} /></td></tr>
            <tr><td>+0 mi:</td><td><SingleDistanceBar distance={distances["0"]} /></td></tr>
            <tr><td>+.9 mi:</td><td><SingleDistanceBar distance={distances["-1"]} /></td></tr>
            <tr><td>+.8 mi:</td><td><SingleDistanceBar distance={distances["-2"]} /></td></tr>
            <tr><td>+.7 mi:</td><td><SingleDistanceBar distance={distances["-3"]} /></td></tr>
            <tr><td>+.6 mi:</td><td><SingleDistanceBar distance={distances["-4"]} /></td></tr>
            </tbody>
        </table>
    )
}

function SingleDistanceBar({distance}: {distance: number | null}) {
    if (distance == null) {
        return null
    } else {
        return (
            <code>
                {[...Array(distance)].map(_ => ".").join("")}
            </code>
        )
    }
}