import React from 'react';
import CalculateScore from './Components/CalculateScore';

function App() {
  return (
    <div>
      <CalculateScore
        name="Sujana"
        school="ABC School"
        total={450}
        goal={500}
      />
    </div>
  );
}

export default App;