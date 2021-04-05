import { render, screen } from '@testing-library/react';
import FooterComponent from './FooterComponent';

test('renders application footer', () => {
    render(<FooterComponent />);
    const linkElement = screen.getByText(/Abhinav Panda/i);
    expect(linkElement).toBeInTheDocument();
});