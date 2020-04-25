import * as React from "react";
import HeatMap from "react-heatmap-grid";

export function WeekMap({ data }: { data: number[][] }): JSX.Element {
  const days = ["Mon", "Tues", "Wed", "Thurs", "Fri", "Sat", "Sun"];

  const hours = [
    "1 AM",
    "2 AM",
    "3 AM",
    "4 AM",
    "5 AM",
    "6 AM",
    "7 AM",
    "8 AM",
    "9 AM",
    "10 AM",
    "11 AM",
    "12 AM",
    "1 PM",
    "2 PM",
    "3 PM",
    "4 PM",
    "5 PM",
    "6 PM",
    "7 PM",
    "8 PM",
    "9 PM",
    "10 PM",
    "11 PM",
    "12 PM",
  ];

  const visibility = hours.map((_, index) => index % 2 === 0);

  return (
    <HeatMap
      yLabels={days}
      xLabels={hours}
      squares={true}
      xLabelsVisibility={visibility}
      data={data}
    />
  );
}
