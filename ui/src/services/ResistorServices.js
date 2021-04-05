import axios from 'axios';

const ECC_API_URL = 'http://localhost:8080/ecc';
const COLOR_URL = `${ECC_API_URL}/colors`;
const MULTIPLIER_URL = `${ECC_API_URL}/multiplier`;
const TOLERANCE_URL = `${ECC_API_URL}/tolerance`;
const GET_4_BAND_URL = `${ECC_API_URL}/get4band`;
const GET_5_BAND_URL = `${ECC_API_URL}/get5band`;

class ResistorServices {

    retrieveColorBandValues() {
        return axios.get(`${COLOR_URL}`);
    }

    retrieveMultiplierValues() {
        return axios.get(`${MULTIPLIER_URL}`);
    }

    retrieveToleranceValues() {
        return axios.get(`${TOLERANCE_URL}`);
    }

    retrieve4Band(bandAColor, bandBColor, multiColor, tolColor) {
        return axios.get(`${GET_4_BAND_URL}/${bandAColor}/${bandBColor}/${multiColor}/${tolColor}`);
    }

    retrieve5Band(bandAColor, bandBColor, bandCColor, multiColor, tolColor) {
        return axios.get(`${GET_5_BAND_URL}/${bandAColor}/${bandBColor}/${bandCColor}/${multiColor}/${tolColor}`);

    }
}

export default new ResistorServices()