import * as React from 'react';
import HeatMap from 'react-heatmap-grid';

export function WeekMap({data}: {data: number[][]}): JSX.Element {
  const days = [
    "Monday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday",
    "Saturday",
    "Sunday"
  ]

  const hours = new Array(24)
    .fill(0)
    .map((element, index) => index)
    .map(index => index % 12)
    .map(element => element + 1)
    .map(element => `${element}`)

  return <HeatMap
    yLabels={hours}
    xLabels={days}
    data={data}
  />;
}
