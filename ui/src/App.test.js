import { shallow, configure } from "enzyme";
import App from './App';

it("renders without crashing", () => {
  shallow(<App />);
});
