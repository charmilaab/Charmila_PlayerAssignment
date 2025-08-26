import React, { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { getPlayerById, updatePlayer } from "../services.js";
import PlayerForm from "../components/PlayerForm";
const EditPlayer = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const [player, setPlayer] = useState(null);
  useEffect(() => {
    const fetchData = async () => {
      const res = await getPlayerById(id);
      setPlayer(res.data);
    };
    fetchData();
  }, [id]);
  const handleSubmit = async (updated) => {
    await updatePlayer(id, updated);
    navigate("/players");
  };
  return player ? <PlayerForm initialData={player} onSubmit={handleSubmit} /> : <p>Loading...</p>;
};
export default EditPlayer;
