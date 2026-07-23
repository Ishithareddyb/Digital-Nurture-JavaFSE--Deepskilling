import React from 'react';
import '../Stylesheets/mystyle.css';

function CalculateScore(props) {
  const average = props.total / props.goal;

  return (
    <div className="container">
      <h1 className="heading">Student Score Calculator</h1>

      <p className="details">Name: {props.name}</p>
      <p className="details">School: {props.school}</p>
      <p className="details">Total Score: {props.total}</p>
      <p className="details">Goal: {props.goal}</p>
      <p className="details">Average Score: {average}</p>
    </div>
  );
}

export default CalculateScore;