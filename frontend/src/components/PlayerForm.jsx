import React, { useState, useEffect } from "react";
const PlayerForm = ({ initialData, onSubmit }) => {
  const [player, setPlayer] = useState({
    name: "",
    jerseyNumber: "",
    role: "",
    totalMatches: "",
    teamName: "",
    state: "",
    description: "",
  });
  useEffect(() => {
    if (initialData) {
      setPlayer(initialData);
    }
  }, [initialData]);
  const handleChange = (e) => {
    const { name, value } = e.target;
    setPlayer({
      ...player,
      [name]: value,
    });
  };
  const handleSubmit = (e) => {
    e.preventDefault();
    onSubmit({
      ...player,
      jerseyNumber: parseInt(player.jerseyNumber, 10),
      totalMatches: parseInt(player.totalMatches, 10),
    });  };
  return (
    <form onSubmit={handleSubmit} className="card p-4">
      <h4 className="mb-3">Player Form</h4>
      <div className="mb-3">
        <label className="form-label">Name</label>
        <input
          type="text"
          name="name"
          value={player.name}
          onChange={handleChange}
          className="form-control"
        />
      </div>
      <div className="mb-3">
        <label className="form-label">Jersey Number</label>
        <input
          type="number"
          name="jerseyNumber"
          value={player.jerseyNumber}
          onChange={handleChange}
          className="form-control"
        />  </div>
      <div className="mb-3">
        <label className="form-label">Role</label>
        <select
          name="role"
          value={player.role}
          onChange={handleChange}
          className="form-select"
        >
          <option value="">-- Select Role --</option>
          <option value="Batsman">Batsman</option>
          <option value="Bowler">Bowler</option>
          <option value="Keeper">Keeper</option>
          <option value="AllRounder">AllRounder</option>
        </select>
      </div>
      <div className="mb-3">
        <label className="form-label">Total Matches</label>
        <input
          type="number"
          name="totalMatches"
          value={player.totalMatches}
          onChange={handleChange}
          className="form-control"
        />
      </div>
<div className="mb-3">
        <label className="form-label">Team Name</label>
        <input
          type="text"
          name="teamName"
          value={player.teamName}
          onChange={handleChange}
          className="form-control"
        />  </div>
      <div className="mb-3">
        <label className="form-label">State</label>
        <input
          type="text"
          name="state"
          value={player.state}
          onChange={handleChange}
          className="form-control"
        /> </div>
      <div className="mb-3">
        <label className="form-label">Description</label>
        <textarea
          name="description"
          value={player.description}
          onChange={handleChange}
          className="form-control"
        />
      </div> <button type="submit" className="btn btn-success">Submit</button>  </form>
  );  };
export default PlayerForm;
