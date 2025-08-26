import axios from "axios";
const API_BASE_URL = "http://localhost:8080/api/players";
export const getAllPlayers = () => axios.get(`${API_BASE_URL}/getall`);
export const getPlayerById = (id) => axios.get(`${API_BASE_URL}/${id}`);
export const addPlayer = (player) => axios.post(`${API_BASE_URL}/add`, player);
export const updatePlayer = (id, player) => axios.put(`${API_BASE_URL}/${id}`, player);
export const deletePlayer = (id) => axios.delete(`${API_BASE_URL}/delete/${id}`);
