import React, { useState } from "react";
import { addPlayer } from "../services.js";
import PlayerForm from "../components/PlayerForm";
import { useNavigate } from "react-router-dom";
const AddPlayer = () => {
  const navigate = useNavigate();
  const [serverErrors, setServerErrors] = useState({});
  const handleSubmit = async (player) => {
    try {
      await addPlayer(player);
      navigate("/players");
    } catch (err) {
      const res = err.response;
      if (res && res.status === 400 && typeof res.data === "object") {
        setServerErrors(res.data);
      } else {
        alert(res?.data || "Failed to add player");
      }
    }
  };
  return <PlayerForm onSubmit={handleSubmit} serverErrors={serverErrors} />;
};
export default AddPlayer;
