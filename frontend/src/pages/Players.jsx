import React, { useEffect, useState } from "react";
import { getAllPlayers, deletePlayer } from "../services.js";
import PlayerList from "../components/PlayerList";
const Players = () => {
  const [players, setPlayers] = useState([]);
  const [search, setSearch] = useState("");

  const loadPlayers = async () => {
    const res = await getAllPlayers();
    setPlayers(res.data);
  };

  useEffect(() => {
    loadPlayers();
  }, []);

  const handleDelete = async (id) => {
    await deletePlayer(id);
    loadPlayers();
  };
const filteredPlayers = players.filter((p) =>
    p.teamName.toLowerCase().includes(search.toLowerCase())
  );

  return (
    <div>
      <input
        type="text"
        placeholder="Search by Team Name"
        value={search}
        onChange={(e) => setSearch(e.target.value)}
        className="form-control mb-3"
      />

      <PlayerList players={filteredPlayers} onDelete={handleDelete} />
    </div>
  );
};

export default Players;