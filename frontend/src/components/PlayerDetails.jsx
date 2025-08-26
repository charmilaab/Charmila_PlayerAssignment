import React from "react";

const PlayerDetails = ({ player }) => {
  if (!player) return <p>No player details available.</p>;

  return (
    <div className="card p-4">
        <h4 className="mb-3">Player Details</h4>
      <ul className="list-group">
        <li className="list-group-item"><strong>Name:</strong> {player.name}</li>
        <li className="list-group-item"><strong>Jersey Number:</strong> {player.jerseyNumber}</li>
        <li className="list-group-item"><strong>Role:</strong> {player.role}</li>
        <li className="list-group-item"><strong>Total Matches:</strong> {player.totalMatches}</li>
        <li className="list-group-item"><strong>Team Name:</strong> {player.teamName}</li>
        <li className="list-group-item"><strong>State:</strong> {player.state}</li>
        <li className="list-group-item"><strong>Description:</strong> {player.description}</li>
      </ul>
    </div>
  );
};

export default PlayerDetails;

