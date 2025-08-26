import React from "react";
import { Link } from "react-router-dom";
const PlayerList = ({ players, onDelete }) => (
  <div className="card p-3">
    <h4>Players</h4>
    <table className="table table-striped">
      <thead>
        <tr>
          <th>Name</th>
          <th>Jersey</th>
          <th>Role</th>
          <th>Matches</th>
          <th>Team</th>
          <th>State</th>
          <th>Description</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        {players.map((p) => (
          <tr key={p.id}>
            <td>{p.name}</td>
            <td>{p.jerseyNumber}</td>
            <td>{p.role}</td>
            <td>{p.totalMatches}</td>
            <td>{p.teamName}</td>
            <td>{p.state}</td>
            <td>{p.description}</td>
            <td>
              <Link to={`/edit/${p.id}`} className="btn btn-sm btn-outline-primary me-2">Edit</Link>
              <button className="btn btn-sm btn-outline-danger" onClick={() => onDelete(p.id)}>Delete</button>
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  </div>
);
export default PlayerList;
