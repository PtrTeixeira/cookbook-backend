import * as React from "react";

import "../App.css";
import stravaLogo from "../api_logo_pwrdBy_strava_horiz_gray.svg";

export function Header() {
  return (
    <header className="bg-dark navbar">
      <h1 className="text-white navbar-brand">Your Running Punchcard</h1>
      <img
        src={stravaLogo}
        alt="Powered by Strava"
        className="app-strava-logo"
      />
    </header>
  );
}
