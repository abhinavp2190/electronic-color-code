import { render, screen } from '@testing-library/react';
import HeaderComponent from './HeaderComponent';

test('renders application header', () => {
  render(<HeaderComponent />);
  const linkElement = screen.getByText(/Resistor Color Code Calculator/i);
  expect(linkElement).toBeInTheDocument();
});