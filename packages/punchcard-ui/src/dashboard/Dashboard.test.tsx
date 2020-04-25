import * as React from "react";
import { shallow, mount } from "enzyme";

import { Dashboard } from "./Dashboard";

describe("Dashboard", () => {
  it("renders without crashing", () => {
    const props = {
      isLoaded: true,
      error: null,
      weeklyResults: {},
    };

    mount(<Dashboard {...props} />);
  });

  it("sets the text to loading while loading data", () => {
    const props = {
      isLoaded: false,
      error: null,
      weeklyResults: null,
    };

    const dashboard = shallow(<Dashboard {...props} />);

    expect(dashboard.text()).toEqual("Loading...");
  });

  it("sets the text to the given error if not loading", () => {
    const props = {
      isLoaded: true,
      error: "Could not get data from server",
      weeklyResults: null,
    };

    const dashboard = shallow(<Dashboard {...props} />);

    expect(dashboard.text()).toEqual("Could not get data from server");
  });
});
