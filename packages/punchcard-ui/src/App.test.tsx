import * as React from "react";
import * as ReactDOM from "react-dom";
import axios from "axios";

import "jest-localstorage-mock";

import App, { loadWeeklyResults } from "./App";

jest.mock("axios");

beforeEach(() => {
  sessionStorage.clear();
});

describe("App", () => {
  it("renders without crashing", () => {
    sessionStorage.setItem("results", '{"MONDAY": {}}');

    const div = document.createElement("div");
    ReactDOM.render(<App />, div);
    ReactDOM.unmountComponentAtNode(div);
  });
});

describe("loadWeeklyResults", () => {
  it("loads data from session storage if available", async () => {
    sessionStorage.setItem("results", '{"MONDAY": {}}');
    const data = await loadWeeklyResults();
    expect(data).toStrictEqual({ MONDAY: {} });
  });

  it("loads data from the web otherwise", async () => {
    axios.get.mockResolvedValue({ data: { TUESDAY: { "0": 4 } } });

    const data = await loadWeeklyResults();
    expect(data).toStrictEqual({ TUESDAY: { "0": 4 } });
    expect(sessionStorage.getItem("results")).toStrictEqual(
      JSON.stringify({ TUESDAY: { "0": 4 } })
    );
  });
});
